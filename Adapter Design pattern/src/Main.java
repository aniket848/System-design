import java.util.Arrays;
import java.util.List;

interface Report{
    public String getJSONData(String data);
}

class XMLDataAdaptee{

    public String getXMLData(String data){
        List<String> arr = Arrays.asList(data.split(":"));
        return  "<user>"+
                   "<name> "+ arr.get(0) + " </name> "+
                   "<location> "+ arr.get(1) + " </location>"+
                "</user>";
    }
}

class getJSONDataAdapter implements Report{

    // 'Has-a' relation with getXMLDataAdapter (adaptee)
    XMLDataAdaptee xmlDataAdaptee;

    getJSONDataAdapter(XMLDataAdaptee xmlAdaptee){
        this.xmlDataAdaptee = xmlAdaptee;
    }

    @Override
    public String getJSONData(String data) {
        String xmlData = xmlDataAdaptee.getXMLData(data);

        int startName = xmlData.indexOf("<name>") + 7;
        int endName = xmlData.indexOf("</name>");

        String name = xmlData.substring(startName,endName);

        int startLocation = xmlData.indexOf("<location>") + 10;
        int endLocation = xmlData.indexOf("</location>");

        String location = xmlData.substring(startLocation,endLocation);

        return "{\"name\":" + name + ", \"location\":" + location + "}";

    }
}

class Client{

    public String getReport(String data, Report report){
        return report.getJSONData(data);
    }
}

public class Main {
    public static void main(String[] args) {

         XMLDataAdaptee xmlData = new XMLDataAdaptee();
         Report report = new getJSONDataAdapter(xmlData);

         Client client = new Client();
         String rawData = "Aniket:Bareilly";
         String jsonData = client.getReport(rawData,report);
         System.out.println("jsonData = "+jsonData);

    }
}