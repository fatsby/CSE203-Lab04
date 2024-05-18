import java.util.TreeMap;

public class Dictionary {
    private TreeMap<String, String> dictionary;

    public Dictionary() {
        dictionary = new TreeMap<>();
        dictionary.put("Quintessential", "Representing the most perfect or typical example of a quality or class");
        dictionary.put("Ubiquitous", "Present, appearing, or found everywhere");
        dictionary.put("Ephemeral", "Lasting for a very short time");
        dictionary.put("Serendipity", "The occurrence and development of events by chance in a happy or beneficial way");
        dictionary.put("Petrichor", "A pleasant smell that frequently accompanies the first rain after a long period of warm, dry weather");
        dictionary.put("Supercilious", "Behaving or looking as though one thinks one is superior to others");
        dictionary.put("Ineffable", "Too great or extreme to be expressed or described in words");
        dictionary.put("Luminous", "Full of or shedding light; bright or shining, especially in the dark");
        dictionary.put("Solitude", "The state or situation of being alone");
        dictionary.put("Zenith", "The time at which something is most powerful or successful");
    }

    public void find(String word) {
        String definition = dictionary.get(word);
        System.out.println(word + ": " + definition);
    }

    public void check(String word) {
        if (dictionary.containsKey(word)) {
            find(word);
        } else {
            System.out.println(word + ": not found");
        }
    }
}
