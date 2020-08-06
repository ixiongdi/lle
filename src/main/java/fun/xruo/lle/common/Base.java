package fun.xruo.lle.common;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author xiongdi (kotlin@qq.com)
 * @since 2020/4/30 18:55
 */
@Data
public abstract class Base {
    /**
     * id, bigint unsigned
     */
    private Long id;

    /**
     * create_time, datetime
     */
    private LocalDateTime gmtCreate;
    /**
     * update_time, datetime
     */
    private LocalDateTime gmtModified;

    /**
     * deleted, unsigned tinyint
     */
    private Boolean deleted;
}
