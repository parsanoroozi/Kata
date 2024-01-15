package time_formatter;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimeFormatterTest {
    @Test
    public void exampleTests() {
        Assert.assertEquals("1 second", TimeFormatter.formatDuration(1));
        Assert.assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
        Assert.assertEquals("2 minutes", TimeFormatter.formatDuration(120));
        Assert.assertEquals("1 hour", TimeFormatter.formatDuration(3600));
        Assert.assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));
    }
}
