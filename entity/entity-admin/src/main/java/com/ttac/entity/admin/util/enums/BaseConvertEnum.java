package com.ttac.entity.admin.util.enums;

import com.ttac.entity.admin.exception.enums.EnumException;
import com.ttac.entity.base.exception.CustomException;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * introduce：枚举泛型对象 保存、获取 类容的转换
 *
 * @date: 2018/9/27
 * @author: bang.tang
 * @time: 14:23
 */
@Slf4j
public abstract class BaseConvertEnum<T extends BaseEnum> implements AttributeConverter<BaseEnum, Integer> {


    private Class<T> clazz;

    public BaseConvertEnum() {
    }

    /**
     * 使用反射技术得到T的真实类型
     * @return
     */
    public Class getRealClassType(){
        // 获取当前new的对象的泛型的父类类型
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] types = type.getActualTypeArguments();
        // 获取第一个类型参数的真实类型
        if ((null != types) && (types.length > 0)){
            this.clazz = (Class<T>) types[0];
            return clazz;
        }
        log.error("当前对象:{}获取对象类型失败!", type.getTypeName());
        return null;
    }

    /**
     * y convertToDatabaseColumn(x) 作用：将实体属性x转化为y存储到数据库中，即插入和更新操作时执行；
     * @param attribute
     * @return
     */
    @Override
    public Integer convertToDatabaseColumn(BaseEnum attribute) {
        if (null == attribute){
            log.error("枚举:{}获取number失败!");
            throw new CustomException(EnumException.GET_CODE_ERROR);
        }
        return attribute.getCode();
    }

    /**
     * x convertToEntityAttribute(y) 作用：将数据库中的字段y转化为实体属性x，即查询操作时执行。
     * @param dbData
     * @return
     */
    @Override
    public T convertToEntityAttribute(Integer dbData) {
        Map<Integer, T> map = getMap();
        if (null != map && !map.isEmpty()){
            return map.get(dbData);
        }
        return null;
    }




    /**
     * 返回枚举的map集合
     * @return
     */
    public  Map<Integer, T> getMap(){
        // 泛型的上限 接收BaseEnum类型或者BaseEnum的子类型。
        Class<? super BaseEnum> realClassType = this.getRealClassType();
        if (null != realClassType && realClassType.isEnum()){
            T[] enumConstants = (T[]) realClassType.getEnumConstants();
            if (null != enumConstants && !(enumConstants.length == 0)){
                Map<Integer, T> map = new HashMap<>(enumConstants.length);
                for (BaseEnum baseEnum : enumConstants){
                    map.put(baseEnum.getCode(), (T) baseEnum);
                }
                return  map;
            }
        }
        return null;
    }
}
