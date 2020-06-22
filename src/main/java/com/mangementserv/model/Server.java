package com.mangementserv.model;

import com.mangementserv.enumaration.CommandTypeEnum;
import lombok.Data;

import java.util.Map;

@Data
public class Server {

    private int id;

    private String name;

    private String snapShotName;

    private Map<CommandTypeEnum,String> commands;

}
