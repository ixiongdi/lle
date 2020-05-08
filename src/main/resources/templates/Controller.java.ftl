package ${packageName}.controller;

import fun.xruo.lle.common.BaseController;
import ${packageName}.pojo.${upperCamelName};
import ${packageName}.service.${upperCamelName}Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* @author CodeGenerate (https://github.com/ixiongdi/lle)
* @since ${.now}
* ${name}
*/
@RestController
@RequestMapping("/api/sys/${name}")
public class ${upperCamelName}Controller extends BaseController {

@Resource
${upperCamelName}Service ${lowerCamelName}Service;

@RequestMapping("index")
public Object index(Integer page, Integer size) {

return ok();
}

@RequestMapping("get")
public Object get(Long id) {

return ok(${lowerCamelName}Service.get(id));
}

@RequestMapping("list")
public Object list(${upperCamelName} ${lowerCamelName}) {

return ok(${lowerCamelName}Service.list(${lowerCamelName}));
}

@RequestMapping("save")
public Object save(${upperCamelName} ${lowerCamelName}) {
${lowerCamelName}Service.save(${lowerCamelName});
return ok();
}

@RequestMapping("insert")
public Object insert(${upperCamelName} ${lowerCamelName}) {
${lowerCamelName}Service.insert(${lowerCamelName});
return ok();
}

@RequestMapping("count")
public Object count(${upperCamelName} ${lowerCamelName}) {
return ok(${lowerCamelName}Service.count(${lowerCamelName}));
}

@RequestMapping("delete")
public Object delete(Long id) {
${lowerCamelName}Service.delete(id);
return ok();
}

@RequestMapping("remove")
public Object remove(Long id) {
${lowerCamelName}Service.remove(id);
return ok();
}

@RequestMapping("update")
public Object update(${upperCamelName} ${lowerCamelName}) {
${lowerCamelName}Service.update(${lowerCamelName});
return ok();
}
}
