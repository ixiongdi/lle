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
     * create_time, datetime
     */
    private LocalDateTime createTime;
    /**
     * update_time, datetime
     */
    private LocalDateTime updateTime;

    /**
     * deleted, unsigned tinyint
     */
    private Boolean deleted;
}
