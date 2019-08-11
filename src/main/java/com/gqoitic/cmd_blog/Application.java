package com.gqoitic.cmd_blog;

import com.gqoitic.cmd_blog.cmd_interface.Interf_controller;

public class Application {

    private static Interf_controller interf = new Interf_controller();

    public static void main(String[] args) {
        interf.applicationProcess();
    }
}
