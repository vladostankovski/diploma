package fri.diplomska.diplomska.helpers;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {

    public static String getProjectPath(HttpServletRequest request) {
        Path currentWorkingDir = Paths.get("webapps").toAbsolutePath();
        return currentWorkingDir.normalize().toString() + File.separator + request.getContextPath();
    }

}
