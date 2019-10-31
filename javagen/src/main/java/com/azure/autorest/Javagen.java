package com.azure.autorest;

import com.azure.autorest.extension.base.jsonrpc.Connection;
import com.azure.autorest.extension.base.models.Message;
import com.azure.autorest.extension.base.plugin.JavaSettings;
import com.azure.autorest.extension.base.plugin.NewPlugin;
import com.azure.autorest.mapper.Mappers;
import com.azure.autorest.model.clientmodel.ClassType;
import com.azure.autorest.model.clientmodel.EnumType;
import com.azure.autorest.model.clientmodel.IType;
import com.azure.autorest.model.codemodel.ChoiceSchema;
import com.azure.autorest.model.codemodel.CodeModel;
import com.azure.autorest.model.codemodel.TypeEnumConstructor;
import com.azure.autorest.model.javamodel.JavaFile;
import com.azure.autorest.model.javamodel.JavaFileFactory;
import com.azure.autorest.template.Templates;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.representer.Representer;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Javagen extends NewPlugin {
    private final Yaml yamlMapper;

    public Javagen(Connection connection, String plugin, String sessionId) {
        super(connection, plugin, sessionId);
        Representer representer = new Representer();
        representer.getPropertyUtils().setSkipMissingProperties(true);
        yamlMapper = new Yaml(new TypeEnumConstructor(), representer);
//        yamlMapper = new ObjectMapper(new YAMLFactory()
//            .configure(JsonParser.Feature.ALLOW_YAML_COMMENTS, true)
//            .configure(JsonParser.Feature.ALLOW_MISSING_VALUES, true))
//        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
//        .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
//        .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
    }

    @Override
    public boolean processInternal() {
        List<String> files = listInputs();
        if (files.size() != 1)
        {
            throw new RuntimeException(String.format("Generator received incorrect number of inputs: %s : %s}", files.size(), String.join(", ", files)));
        }
        String file = readFile(files.get(0));
        try {
            File tempFile = new File("tempfile.json");
            if (!tempFile.exists()) {
                tempFile.createNewFile();
            }
            new FileOutputStream(tempFile).write(file.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            //
        }
        CodeModel codeModel;
        try {
            if (!file.startsWith("{")) {
                // YAML
                codeModel = yamlMapper.loadAs(file, CodeModel.class);
            } else {
                codeModel = jsonMapper.readValue(file, CodeModel.class);
            }
        } catch (Exception e) {
            System.err.println("Got an error " + e.getMessage());
            connection.sendError(1, 500, "Cannot parse input into code model: " + e.getMessage());
            return false;
        }
        System.err.println("Parsed into code model " + codeModel);
        Message info = new Message();
        info.setChannel("information");
        info.setText("generating file: data.json");
        message(info);
        JavaFileFactory factory = new JavaFileFactory(JavaSettings.getInstance());
        for (ChoiceSchema choiceSchema : codeModel.getSchemas().getChoices()) {
            IType iType = Mappers.getChoiceMapper().map(choiceSchema);
            if (iType != ClassType.String) {
                EnumType enumType = (EnumType) iType;
                JavaFile javaFile = factory.createSourceFile(JavaSettings.getInstance().getPackage(), enumType.getName());
                Templates.getEnumTemplate().write(enumType, javaFile);
                writeFile(javaFile.getFilePath(), javaFile.getContents().toString(), null);
            }
        }
        writeFile("data.json", "{\"output\": \"" + codeModel.getInfo().getTitle() + "\"}", null);
        return true;
    }
}