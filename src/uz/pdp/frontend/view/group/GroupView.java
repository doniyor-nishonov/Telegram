package uz.pdp.frontend.view.group;

import uz.pdp.backend.model.group.Group;
import uz.pdp.backend.model.userGroup.UserGroup;
import uz.pdp.backend.service.group.GroupService;
import uz.pdp.backend.service.group.GroupServiceImp;
import uz.pdp.backend.service.user.UserService;
import uz.pdp.backend.service.user.UserServiceImp;
import uz.pdp.backend.service.userGroup.UserGroupService;
import uz.pdp.backend.service.userGroup.UserGroupServiceImp;

import java.util.List;
import java.util.Objects;

import static uz.pdp.frontend.utils.MenuUtils.*;
import static uz.pdp.frontend.utils.Utils.*;
import static uz.pdp.frontend.ui.UI.*;

public class GroupView {
    private static final GroupService groupService = GroupServiceImp.getInstance();
    private static final UserGroupService userGroupService = UserGroupServiceImp.getInstance();
    private static final UserService userService = UserServiceImp.getInstance();

    public static void myGroup() {

    }

    public static void group() {
        while (true) {
            int menu = menu(GROUP);
            switch (menu) {
                case 1 -> createGroup();
                case 2 -> joinGroup();
                case 3 -> leaveGroup();
                case 4 -> showGroups();
                case 0 -> {
                    return;
                }
                default -> System.out.println(RED + "Invalid choice" + STOP);
            }
        }
    }

    private static void createGroup() {
        String name = inputStr("Name");
        boolean isWorked = groupService.add(new Group(curUser.getId(), name));
        notificationMessage("Group", "created", isWorked);
    }

    private static void joinGroup() {
        String name = inputStr("Name");
        List<Group> groups = groupService.findByName(name);
        checkData(groups);
        if (groups.isEmpty()) return;
        int i = 1;
        for (Group group : groups)
            System.out.printf("%d. %s%n", i++, group);
        int index = inputInt("Choose") - 1;
        if (index < 0 || index > groups.size()) {
            System.out.println(RED + "Invalid choice" + STOP);
            return;
        }
        Group group = groups.get(index);
        if (Objects.equals(group.getUserId(), curUser.getId())) {
            System.out.println(RED + "You are already subscribed" + STOP);
            return;
        }
        boolean isWorked = userGroupService.add(new UserGroup(curUser.getId(), group.getId()));
        notificationMessage("Group", "joined", isWorked);
    }

    private static void leaveGroup() {
//        userGroupService.delete()
    }

    private static void showGroups() {

    }
}
