package fun.xruo.lle.common;

import java.util.List;

/**
 * @author xiongdi
 */
public record BaseQuery(Long current, Long size, List<Long>ids) { }
