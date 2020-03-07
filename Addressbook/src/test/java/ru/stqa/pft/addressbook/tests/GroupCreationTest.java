package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        List<GroupDate> before = app.getGroupHelper().getGroupList();
        GroupDate group = new GroupDate("aaa1", "bbb", "ccc");
        app.getGroupHelper().createGroup(group);
        List<GroupDate> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.setId(after.stream().max(Comparator.comparingInt(o -> o.getId())).get().getId());
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


    }


}
