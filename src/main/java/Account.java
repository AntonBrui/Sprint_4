public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if(name != null){
            if(name.length() >= 3
                    && name.length() <= 19
                    && name.length() - name.replace(" ", "").length() == 1
                    && name.trim().length() == name.length()) {
                return true;
            }
        }
        return false;
    }
}