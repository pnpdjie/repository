import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.yaml.snakeyaml.Yaml;

public class ParseYml {
	public static void main(String[] args) {

		Yaml yaml = new Yaml();
		String yamlStr;
		try {
			yamlStr = preLoad("guides.yml");
			Object result = yaml.load(yamlStr);
			System.out.println(result.getClass());
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    private static String preLoad(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");  
        BufferedReader fileReader = new BufferedReader(isr);
        String temp;
        StringBuilder stringBuilder = new StringBuilder();
        while ((temp = fileReader.readLine()) != null) {
            if (temp.trim().startsWith("!!")) {
                continue;
            }
            stringBuilder.append(temp + "\n");
        }
        String result = stringBuilder.toString();
        System.out.println("YAML ->" + result);

        return result;
    }
}
