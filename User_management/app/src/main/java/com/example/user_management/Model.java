package com.example.user_management;

public class Model {
        private String fullname;
        private String email;
        private String phone;
        private String gender;

        public Model(String fullname, String email ,String phone, String gender) {
            this.fullname = fullname;
            this.email = email;
            this.phone = phone;
            this.gender = gender;
        }

        public String getHead() {
            return fullname;
        }

        public String getDesc() {
            return email;
        }

        public String getPhone() { return phone;}

        public String getGender() { return gender;}

    }
