<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${packageName}.dao.${upperCamelName}DAO">

    <sql id="whereClause">
        <#list columns as column>
            <if test="null != ${column.lowerCamelName}">
                and ${column.name} = ${column.lowerCamelName}
            </if>
        </#list>
    </sql>

    <sql id="updateClause">
        <set>
            <#list columns as column>
                <#switch column.lowerCamelName>
                    <#case 'id'>
                        <#break>
                    <#case 'createTime'>
                        <#break>
                    <#case 'updateTime'>
                        update_time = CURRENT_TIMESTAMP(),
                        <#break>
                    <#case 'deleted'>
<#--                        deleted = ${deleted}-->
                        <#break>
                    <#default>
                        <if test="null != ${column.lowerCamelName}">
                            and ${column.name} = ${column.lowerCamelName}
                        </if>
                </#switch>
            </#list>
        </set>
    </sql>

    <sql id="baseColumns">
        <#list columns?filter(p -> !p.required) as column>
            ${column.name}<#sep>,
        </#list>
    </sql>

    <sql id="fullColumns">
        <#list columns as column>
            ${column.name}<#sep>,</#sep>

            </#list>
    </sql>

    <sql id="selectClause">
        <#list columns as column>
            ${column.name} as ${column.lowerCamelName}<#sep>,</#sep>
        </#list>
    </sql>

    <insert id="insert" parameterType="${name}">
        INSERT INTO ${name} (<include refid="baseColumns"></include>)
        VALUES (
        <#list columns?filter(p -> !p.required) as column>
            ${"#"}${"{"}${column.lowerCamelName}${"}"}<#sep>,
        </#list>
        )
    </insert>

    <insert id="insertBatch" parameterType="list">
        INSERT INTO ${name} (<include refid="baseColumns"></include>)
        VALUES
        <foreach item="item" index="index" collection="list" open="" separator="," close="">
            (<#list columns as column>
            ${column.lowerCamelName}<#sep>,</#sep>
            </#list>)
        </foreach>
    </insert>

    <select id="select" parameterType="sys_user" resultType="${name}">
        SELECT
        <include refid="selectClause"></include>
        FROM ${name}
        <where>
            <include refid="whereClause"></include>
        </where>
    </select>

    <select id="selectById" parameterType="long" resultType="${name}">
        SELECT
        <include refid="selectClause"></include>
        FROM ${name}
        WHERE id = ${"#"}{id}
    </select>

    <select id="selectBatchByIds" parameterType="list" resultType="${name}">
        SELECT
        <include refid="selectClause"></include>
        FROM ${name}
        WHERE id in
        <foreach item="item" index="index" collection="ids" open="(" separator="," close=")">
            ${'#'}{item}
        </foreach>
    </select>

    <select id="selectBatchByArgs" parameterType="map" resultType="${name}">
        SELECT
        <include refid="selectClause"></include>
        FROM ${name}
        <where>
            <include refid="whereClause"></include>
        </where>
    </select>

    <select id="count" parameterType="${name}" resultType="long">
        SELECT COUNT(*) FROM ${name}
        <where>
            <include refid="whereClause"></include>
        </where>
    </select>

    <select id="countByArgs" parameterType="map" resultType="long">
        SELECT COUNT(*) FROM ${name}
        <where>
            <include refid="whereClause"></include>
        </where>
    </select>

    <update id="update" parameterType="${name}">
        UPDATE sys_user
        <include refid="updateClause"></include>
        WHERE id =  ${'#'}{id}
    </update>

    <update id="updateById">
        UPDATE sys_user
        <include refid="updateClause"></include>
        WHERE id =  ${'#'}{id}
    </update>

    <update id="updateBatchByIds">
        UPDATE ${name}
        <include refid="updateClause"></include>
        WHERE id in
        <foreach item="item" index="index" collection="ids" open="(" separator="," close=")">
            ${'#'}{item}
        </foreach>
    </update>

    <update id="updateBatchByArgs" parameterType="map">
        UPDATE ${name}
        <include refid="updateClause"></include>
        <where>
            <include refid="whereClause"></include>
        </where>
    </update>

    <delete id="delete" parameterType="${name}">
        DELETE FROM ${name}
        <where>
            <include refid="whereClause"></include>
        </where>
    </delete>

    <delete id="deleteById" parameterType="long">
        DELETE FROM ${name} WHERE id = ${'#'}{id}
    </delete>

    <delete id="deleteBatchByIds" parameterType="list">
        DELETE FROM ${name} WHERE id in
        <foreach item="item" index="index" collection="ids" open="(" separator="," close=")">
            ${r'#{item}'}
        </foreach>
    </delete>

    <select id="deleteBatchByArgs" parameterType="map">
        DELETE FROM ${name}
        <where>
            <include refid="whereClause"></include>
        </where>
    </select>


</mapper>