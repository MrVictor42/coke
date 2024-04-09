package br.com.victor.coke.service.mondayIntegration;

public class MondayIntegrationQuery {
    public static final String USERS_QUERY =
    "query{\n" +
        "  users {\n" +
            "    id\n" +
            "    email\n" +
            "    name\n" +
            "    enabled\n" +
            "    account {\n" +
                "      id\n" +
                "      name\n" +
                "    }\n" +
            "  }\n" +
            "}\n"
    ;
}