package fun.xruo.lle.common;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author kevin
 */
@Data
public abstract class BaseDO {
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
