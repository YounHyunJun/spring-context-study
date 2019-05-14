package study.spring.context.bean.wrapper;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import study.spring.context.bean.Spark;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BeanWrapperTests {

    @Test
    public void READABLE_PROPERTY_테스트() {
        Spark spark = new Spark();
        BeanWrapperImpl bw = new BeanWrapperImpl(spark);
        boolean color = bw.isReadableProperty("color");
        boolean name = bw.isReadableProperty("name");
        boolean size = bw.isReadableProperty("size");

        boolean noValue = bw.isReadableProperty("noValue");

        assertFalse(color); // setter 만 존재
        assertTrue(name); // getter/setter 존재
        assertTrue(size); // getter 만 존재

        assertFalse(noValue); // 메소드가 없음

        try {
            bw.isReadableProperty(null);
            fail();
        } catch (IllegalArgumentException ignore) {}
    }

    @Test
    public void WRITABLE_PROPERTY_TEST() {
        BeanWrapper bw = new BeanWrapperImpl(Spark.class);

        assertTrue(bw.isReadableProperty("toolMap"));
        assertTrue(bw.isReadableProperty("doorArray"));
        assertTrue(bw.isReadableProperty("seatList"));

        assertTrue(bw.isWritableProperty("toolMap"));
        assertTrue(bw.isWritableProperty("doorArray"));
        assertTrue(bw.isWritableProperty("seatList"));

        assertTrue(bw.isReadableProperty("doorArray[0]"));
        assertTrue(bw.isReadableProperty("doorArray[0].material"));
        assertTrue(bw.isReadableProperty("seatList[0]"));
        assertTrue(bw.isReadableProperty("toolMap[key1]"));

        assertTrue(bw.isWritableProperty("doorArray[0]"));
        assertTrue(bw.isWritableProperty("doorArray[0].material"));
        assertTrue(bw.isWritableProperty("seatList[0]"));
        assertTrue(bw.isWritableProperty("toolMap[key1]"));
    }

    @Test
    public void 타입_결정_인덱스_속성() {
        BeanWrapper bw = new BeanWrapperImpl(Spark.class);
        assertEquals(null, bw.getPropertyType("map[key0]"));

        bw.setPropertyValue("toolMap[key0]", "hammer");
        assertEquals(String.class, bw.getPropertyType("toolMap[key0]"));
    }

    @Test
    public void PROPERTY_GETTER_SETTER_테스트() {
        BeanWrapper bw = new BeanWrapperImpl(new Spark());
        bw.setPropertyValue("name", "jun");
        assertEquals("jun", bw.getPropertyValue("name"));
    }

}
