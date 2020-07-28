package thriftDemo.server;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thriftDemo.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class UserServiceImpl implements UserService.Iface {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Map<Integer, String> nameIdMap = new HashMap<Integer, String>() {{
        put(1, "Harry");
        put(2, "Jack");
        put(3, "Bob");
    }};

    public UserServiceImpl() {
    }

    @Override
    public String getName(int id) throws TException {
        logger.info("received getName, id = {}:", id);
        return nameIdMap.getOrDefault(id, "NULL");
    }

    @Override
    public boolean isExist(String name) throws TException {
        logger.info("receive isExist, name = {}", name);
        return nameIdMap.containsValue(name);
    }
}
