package app;

public enum reqActions {
    DOMAINS("getDomainList"),
    MESSAGES("getMessages");



    String value;
    reqActions(String value) {
        this.value = value;
    }
}
