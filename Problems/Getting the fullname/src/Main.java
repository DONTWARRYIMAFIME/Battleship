class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName != null ? firstName : "";
    }

    public void setLastName(String lastName) {
        this.lastName = lastName != null ? lastName : "";
    }

    public String getFullName() {
        String result;
        result = "Unknown";

        if (!"".equals(firstName) && !"".equals(lastName)) {
            result = firstName + " " + lastName;
        } else if (!"".equals(firstName)) {
            result = firstName;
        } else if (!"".equals(lastName)) {
            result = lastName;
        }

        return result;
    }
}

