public class Codec {
    HashMap<String, String> urlCodePair = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int prime = 3;
        for(int i = 0; i < longUrl.length(); i++){
            prime += prime + longUrl.charAt(i);
        }
        urlCodePair.put(""+prime,longUrl);
        return "tinyUrl.com/" + prime;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlCodePair.get(shortUrl.substring(12));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));