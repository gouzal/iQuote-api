package com.gouzal.iquote.seeder;

import com.gouzal.iquote.model.Role;
import com.gouzal.iquote.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleSeeder extends AbstractTableSeeder {
    final private RoleService roleService;

    @Autowired
    public RoleSeeder(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run() {
        String[] roles = {"normal_user", "admin"};
        for (int i = 0; i < roles.length; i++) {
            Role role = new Role();
            role.setLabel(roles[i]);
            this.roleService.save(role);
        }
    }
}
