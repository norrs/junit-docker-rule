package pl.domzal.junit.docker.rule.wait;

import pl.domzal.junit.docker.rule.DockerRule;
import pl.domzal.junit.docker.rule.wait.WaitChecker;

/**
 * {@link WaitChecker} met when container log lines contains specified message.
 */
public class LogChecker implements WaitChecker {

    private final DockerRule rule;
    private final String waitForMessage;

    public LogChecker(DockerRule rule, String waitForMessage) {
        this.rule = rule;
        this.waitForMessage = waitForMessage;
    }

    @Override
    public boolean check() {
        return rule.getLog().contains(waitForMessage);
    }

    @Override
    public String describe() {
        return String.format("log message '%s'", waitForMessage);
    }

    @Override
    public void after() { }

}
