import com.example.web.PlayRestController;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyd
 * @date 2019/03/29
 */
public class PlayRestControllerTest {

    private static PlayRestController controller;

    @BeforeClass
    public static void init() {
        controller = new PlayRestController();
    }

    @Test
    public void dataBindingDemo1() {
        Map<String, Object> tocRequest = new HashMap<>();
        tocRequest.put("userType", "TOC");
        tocRequest.put("id", 1111);
        tocRequest.put("name", "toc user");
        tocRequest.put("toc", "right");

        controller.get("data.binding.demo1", tocRequest, HashMap.class);

        Map<String, Object> tobRequest = new HashMap<>();
        tobRequest.put("userType", "TOB");
        tobRequest.put("id", 2222);
        tobRequest.put("name", "tob user");
        tobRequest.put("tob", "right");

        controller.get("data.binding.demo1", tobRequest, HashMap.class);
    }

}
