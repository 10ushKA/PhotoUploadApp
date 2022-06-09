package by.niitzi.byshylo.command;

public class CommandFactory {
    public static Command command(String command){
        Command temp = null;
        if(command != null){
            try{
                temp = CommandType.valueOf(command.toUpperCase().replaceAll("-", "_")).getCommand();
            }catch (IllegalArgumentException e){
                temp = CommandType.TO_HOME.getCommand();
            }
        }
        //home?command=to-home
        //"/home", "/upload", "/download"

        //upload?command=
        //download?command=
        return temp != null ? temp : CommandType.TO_HOME.getCommand();
    }
}
