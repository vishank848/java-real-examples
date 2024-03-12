package org.example.json;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;

public class GenerateClasses {
    private static final String FILE_NAME = "D:\\development_sita_champ\\data\\awb_message.json";
    private static final String TEST_FILE_NAME = "test-example.json";
    private static final String AWB_FILE_NAME = "awbMove.json";
    public static void main(String[] args) {
        try {
            URL url = new File(FILE_NAME).toURI().toURL();
            File file = new File("D:\\");
            new GenerateClasses().convertJsonToJavaClass(url, file, "org.example", "Awb");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void convertJsonToJavaClass(URL inputJsonUrl, File outputJavaClassDirectory, String packageName,
                                       String javaClassName)
        throws IOException {
        JCodeModel jcodeModel = new JCodeModel();
        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() {
                return true;
            }

            @Override
            public SourceType getSourceType() {
                return SourceType.JSON;
            }
        };

        var mapper = new SchemaMapper(
            new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
        mapper.generate(jcodeModel, javaClassName, packageName, inputJsonUrl);
        jcodeModel.build(outputJavaClassDirectory);
    }
}
