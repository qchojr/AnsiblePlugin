package ir.msdehghan.plugins.ansible.model.ansible;

import ir.msdehghan.plugins.ansible.model.yml.DefaultYamlField;
import ir.msdehghan.plugins.ansible.model.yml.YamlTypes;
import ir.msdehghan.plugins.ansible.model.yml.type.api.YamlField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ir.msdehghan.plugins.ansible.model.yml.type.api.YamlField.Relation.Sequence;

public final class AnsibleFields {
    public static final List<YamlField> TAGGABLE = Arrays.asList(getTaggableFields());
    public static final List<YamlField> CONDITIONAL = Arrays.asList(getConditionalFields());
    public static final List<YamlField> BASE = Arrays.asList(getBaseFields());

    private static YamlField[] getConditionalFields() {
        YamlField when = DefaultYamlField.create("when")
                .setType(YamlTypes.STRING)
                .setType(Sequence, YamlTypes.STRING)
                .setDescription("Conditional expression, determines if an iteration of a task is run or not.");
        return new YamlField[] { when };
    }

    private static YamlField[] getTaggableFields() {
        YamlField tags = DefaultYamlField.create("tags")
                .setType(YamlTypes.STRING) //TODO: add always and never
                .setType(Sequence, YamlTypes.STRING)
                .setDescription("Tags applied to the task or included tasks, this allows selecting subsets of tasks from the command line.");
        return new YamlField[] { tags };
    }

    private static YamlField[] getBaseFields() {
        List<YamlField> list = new ArrayList<>();

        YamlField name = DefaultYamlField.create("name").setType(YamlTypes.STRING)
                .setDescription("Identifier. Can be used for documentation, in or tasks/handlers.");
        list.add(name);

        // Connection/transport
        YamlField connection = DefaultYamlField.create("connection").setType(YamlTypes.STRING)
                .setDescription("Allows you to change the connection plugin used for tasks to execute on the target.");
        list.add(connection);

        YamlField port = DefaultYamlField.create("port").setType(YamlTypes.INTEGER)
                .setDescription("Used to override the default port used in a connection.");
        list.add(port);

        YamlField remote_user = DefaultYamlField.create("remote_user").setType(YamlTypes.STRING)
                .setDescription("User used to log into the target via the connection plugin.");
        list.add(remote_user);

        // Variables
        YamlField vars = DefaultYamlField.create("vars").setType(YamlTypes.ANY)
                .setDescription("Dictionary/map of variables.");
        list.add(vars);

        // Module default params
        YamlField module_defaults = DefaultYamlField.create("module_defaults").setType(YamlTypes.STRING)
                .setDescription("Specifies default parameter values for modules.");
        list.add(module_defaults);

        // Flags and misc. settings
        YamlField environment = DefaultYamlField.create("environment").setType(YamlTypes.ANY)
                .setDescription("A dictionary that gets converted into environment vars to be provided for the task upon execution. This cannot affect Ansible itself nor its configuration, it just sets the variables for the code responsible for executing the task.");
        list.add(environment);

        YamlField no_log = DefaultYamlField.create("no_log").setType(YamlTypes.BOOLEAN)
                .setDescription("Boolean that controls information disclosure.");
        list.add(no_log);

        YamlField run_once = DefaultYamlField.create("run_once").setType(YamlTypes.BOOLEAN)
                .setDescription("Boolean that will bypass the host loop, forcing the task to attempt to execute on the first host available and afterwards apply any results and facts to all active hosts in the same batch.");
        list.add(run_once);

        YamlField ignore_errors = DefaultYamlField.create("ignore_errors").setType(YamlTypes.BOOLEAN)
                .setDescription("Boolean that allows you to ignore task failures and continue with play. It does not affect connection errors.");
        list.add(ignore_errors);

        YamlField ignore_unreachable = DefaultYamlField.create("ignore_unreachable").setType(YamlTypes.BOOLEAN)
                .setDescription("Boolean that allows you to ignore unreachable hosts and continue with play. This does not affect other task errors (see ignore_errors) but is useful for groups of volatile/ephemeral hosts.");
        list.add(ignore_unreachable);

        YamlField check_mode = DefaultYamlField.create("check_mode").setType(YamlTypes.BOOLEAN)
                .setDescription("A boolean that controls if a task is executed in 'check' mode");
        list.add(check_mode);

        YamlField diff = DefaultYamlField.create("diff").setType(YamlTypes.STRING)
                .setDescription("Toggle to make tasks return 'diff' information or not.");
        list.add(diff);

        YamlField any_errors_fatal = DefaultYamlField.create("any_errors_fatal").setType(YamlTypes.STRING)
                .setDescription("Force any un-handled task errors on any host to propagate to all hosts and end the play.");
        list.add(any_errors_fatal);

        YamlField throttle = DefaultYamlField.create("throttle").setType(YamlTypes.INTEGER)
                .setDescription("Limit number of concurrent task runs on task, block and playbook level. This is independent of the forks and serial settings, but cannot be set higher than those limits. For example, if forks is set to 10 and the throttle is set to 15, at most 10 hosts will be operated on in parallel.");
        list.add(throttle);

        // Explicitly invoke a debugger on tasks
        YamlField debugger = DefaultYamlField.create("debugger").setType(YamlTypes.STRING)
                .setDescription("Enable debugging tasks based on state of the task result. See Playbook Debugger");
        list.add(debugger);

        // Privilege escalation
        YamlField become = DefaultYamlField.create("become").setType(YamlTypes.BOOLEAN)
                .setDescription("Boolean that controls if privilege escalation is used or not on Task execution.");
        list.add(become);

        YamlField become_exe = DefaultYamlField.create("become_exe").setType(YamlTypes.STRING);
        list.add(become_exe);

        YamlField become_flags = DefaultYamlField.create("become_flags").setType(YamlTypes.STRING)
                .setDescription("A string of flag(s) to pass to the privilege escalation program when become is True.");
        list.add(become_flags);

        YamlField become_method = DefaultYamlField.create("become_method").setType(YamlTypes.STRING)
                .setDescription("Which method of privilege escalation to use (such as sudo or su).");
        list.add(become_method);

        YamlField become_user = DefaultYamlField.create("become_user").setType(YamlTypes.STRING)
                .setDescription("User that you 'become' after using privilege escalation. The remote/login user must have permissions to become this user.");
        list.add(become_user);

        return list.toArray(new YamlField[0]);
    }

    private AnsibleFields() {
        // This class is a utility class
    }
}
