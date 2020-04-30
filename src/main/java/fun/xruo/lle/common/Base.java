package fun.xruo.lle.common;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author xiongdi (kotlin@qq.com)
 * @since 2020/4/30 18:55
 */
@Data
public class Base {
    /**
     * id, bigint unsigned
     */
    private Long id;

    /**
     * gmt_create, datetime
     */
    private LocalDateTime gmtCreate;
    /**
     * gmt_modified, datetime
     */
    private LocalDateTime gmtModified;

    /**
     * is_deleted, unsigned tinyint
     */
    private Boolean deleted;
}
