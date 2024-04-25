package src;

public enum Tables {
    TABLE_1("Chandragupta Maurya"),
    TABLE_2("Ashoka"),
    TABLE_3("Samudragupta"),
    TABLE_4("Chandragupta II (Vikramaditya)"),
    TABLE_5("Rajaraja Chola I"),
    TABLE_6("Harshavardhana"),
    TABLE_7("Pulakeshin II"),
    TABLE_8("Rajendra Chola I"),
    TABLE_9("Prithviraj Chauhan"),
    TABLE_10("Maharana Pratap"),
    TABLE_11("Krishnadevaraya"),
    TABLE_12("Rani Lakshmi Bai"),
    TABLE_13("Rana Pratap Singh"),
    TABLE_14("Raja Raja Chola III"),
    TABLE_15("Maharana Ranjit Singh"),
    TABLE_16("Ashokavarman"),
    TABLE_17("Gautamiputra Satakarni"),
    TABLE_18("Deva Raya II"),
    TABLE_19("Hemu Vikramaditya");

    private final String kingName;

    Tables(String kingName) {
        this.kingName = kingName;
    }

    public String getKingName() {
        return kingName;
    }
}
