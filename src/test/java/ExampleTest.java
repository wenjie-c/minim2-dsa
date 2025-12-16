import edu.upc.backend.TeamDAO;
import edu.upc.backend.models.Team;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.NameNotFoundException;

public class ExampleTest {

    private static final Logger log = Logger.getLogger(ExampleTest.class);
    int a, b, c;
    TeamDAO _teams = null;
    @Before
    public void setUp() throws Exception{
        a = 8;
        b = 3;
        _teams = TeamDAO.getInstance();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testArithmetica() throws Exception {
        c = a + b;
        Assert.assertEquals(11, c);
        log.info(String.format("c equals %d", c));
    }

    @Test
    public void testDAO()
    {
        Team res = _teams.find(0);
        log.info(res.toString());
    }

    @Test
    public void testDAO2() throws NameNotFoundException {
        Team res = _teams.find("porxinos");
        log.info(res.toString());
    }
}
