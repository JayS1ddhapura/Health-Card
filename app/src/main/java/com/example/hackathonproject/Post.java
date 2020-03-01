package com.example.hackathonproject;

public class Post {

    private String HCID;
    private String password;

    private String firstName;
    private String lastName;
    private String contact_no;
    private String address1;
    private String address2;
    private String city;
    private String district;
    private String postalCode;
    private String state;
    private String email;
    private String aadharCardNumber;
    private String dateOfBirth;
    private String bloodGroup;
    private String wieght;
    private String height;



    public Post(String firstName, String lastName, String contact_no, String address1, String address2, String city, String district, String postalCode, String state, String email, String aadharCardNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact_no = contact_no;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.district = district;
        this.postalCode = postalCode;
        this.state = state;
        this.email = email;
        this.aadharCardNumber = aadharCardNumber;
//        this.dateOfBirth = dateOfBirth;
//        this.bloodGroup = bloodGroup;
//        this.wieght = wieght;
//        this.height = height;
    }

    public Post(String HCID, String password) {
        this.HCID = HCID;
        this.password = password;
    }

    private String CID;
    private String DID;
    private String HID;
    private String Date_time;
    private String probelm__description;
    private String eval_and_cure;
    private String viral_disease;
    private String instruction;
    private String[] prescribed_medicines;
    private String nextOPDDate;

    public String getCID() {
        return CID;
    }

    public String getDID() {
        return DID;
    }

    public String getHID() {
        return HID;
    }

    public String getDate_time() {
        return Date_time;
    }

    public String getProbelm__description() {
        return probelm__description;
    }

    public String getEval_and_cure() {
        return eval_and_cure;
    }

    public String getViral_disease() {
        return viral_disease;
    }

    public String getInstruction() {
        return instruction;
    }

    public String[] getPrescribed_medicines() {
        return prescribed_medicines;
    }

    public String getNextOPDDate() {
        return nextOPDDate;
    }

    private String HCVID;
    private String PassVword;

    private String MBID;
    private String MID;
    private String date_time;
    private String prescrivedBy;

    public String getMBID() {
        return MBID;
    }

    public String getMID() {
        return MID;
    }

    public String getPrescrivedBy() {
        return prescrivedBy;
    }

    private String LRID;
    private String LID;
    private String LDID;
    private String byReferenceOf;

    public String getLRID() {
        return LRID;
    }

    public String getLID() {
        return LID;
    }

    public String getLDID() {
        return LDID;
    }

    public String getByReferenceOf() {
        return byReferenceOf;
    }
}


