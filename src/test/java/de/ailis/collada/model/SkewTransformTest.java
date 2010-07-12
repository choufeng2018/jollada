/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.ailis.gramath.ImmutableVector3f;


/**
 * Tests the SkewTransformation class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class SkewTransformTest
{
    /**
     * Tests the constructor.
     */

    @Test
    public void testConstructor()
    {
        final SkewTransform transform = new SkewTransform();
        assertNull(transform.getSid());
        assertNotNull(transform.getRotationAxis());
        assertNotNull(transform.getTranslationAxis());
        assertEquals(0, transform.getAngle(), 0.001f);
    }


    /**
     * Tests the SID.
     */

    @Test
    public void testSid()
    {
        final SkewTransform transform = new SkewTransform();
        assertNull(transform.getId());
        assertSame(transform, ((ScopeIdentifiable) transform).setSid("foo"));
        assertEquals("foo", transform.getSid());
        transform.setId(null);
        assertNull(transform.getId());
    }


    /**
     * Tests the angle.
     */

    @Test
    public void testAngle()
    {
        final SkewTransform transform = new SkewTransform();
        assertEquals(0, transform.getAngle(), 0.001f);
        assertSame(transform, transform.setAngle(1));
        assertEquals(1, transform.getAngle(), 0.001f);
    }


    /**
     * Tests the translation.
     */

    @Test
    public void testRotationAxis()
    {
        final SkewTransform transform = new SkewTransform();
        assertTrue(transform.getRotationAxis().isNull());
        final ImmutableVector3f translation = new ImmutableVector3f(1, 2, 3);
        assertSame(transform, transform.setRotationAxis(translation));
        assertEquals(translation.getX(), transform.getRotationAxis().getX(),
            0.0001f);
        assertEquals(translation.getY(), transform.getRotationAxis().getY(),
            0.0001f);
        assertEquals(translation.getZ(), transform.getRotationAxis().getZ(),
            0.0001f);
    }


    /**
     * Tests the translation with null parameter.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testRotationAxisWithNull()
    {
        new SkewTransform().setRotationAxis(null);
    }


    /**
     * Tests the translation.
     */

    @Test
    public void testTranslationAxis()
    {
        final SkewTransform transform = new SkewTransform();
        assertTrue(transform.getTranslationAxis().isNull());
        final ImmutableVector3f translation = new ImmutableVector3f(1, 2, 3);
        assertSame(transform, transform.setTranslationAxis(translation));
        assertEquals(translation.getX(), transform.getTranslationAxis().getX(),
            0.0001f);
        assertEquals(translation.getY(), transform.getTranslationAxis().getY(),
            0.0001f);
        assertEquals(translation.getZ(), transform.getTranslationAxis().getZ(),
            0.0001f);
    }


    /**
     * Tests the translation with null parameter.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testTranslationAxisWithNull()
    {
        new SkewTransform().setTranslationAxis(null);
    }
}
