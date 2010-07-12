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
import de.ailis.gramath.MutableVector3f;


/**
 * Tests the LookAtTransformation class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public class LookAtTransformTest
{
    /**
     * Tests the constructor.
     */

    @Test
    public void testConstructor()
    {
        final LookAtTransform transform = new LookAtTransform();
        assertNull(transform.getSid());
        assertNotNull(transform.getEye());
        assertNotNull(transform.getInterest());
        assertNotNull(transform.getUp());
    }


    /**
     * Tests the SID.
     */

    @Test
    public void testSid()
    {
        final LookAtTransform transform = new LookAtTransform();
        assertNull(transform.getId());
        assertSame(transform, ((ScopeIdentifiable) transform).setSid("foo"));
        assertEquals("foo", transform.getSid());
        transform.setId(null);
        assertNull(transform.getId());
    }


    /**
     * Tests the eye vector.
     */

    @Test
    public void testEye()
    {
        final LookAtTransform transform = new LookAtTransform();
        assertTrue(transform.getEye().isNull());
        final ImmutableVector3f translation = new ImmutableVector3f(1, 2, 3);
        assertSame(transform, transform.setEye(translation));
        assertEquals(translation.getX(), transform.getEye().getX(),
            0.0001f);
        assertEquals(translation.getY(), transform.getEye().getY(),
            0.0001f);
        assertEquals(translation.getZ(), transform.getEye().getZ(),
            0.0001f);
    }


    /**
     * Tests the eye vector with null parameter.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testEyeWithNull()
    {
        new LookAtTransform().setEye(null);
    }


    /**
     * Tests the interest vector.
     */

    @Test
    public void testInterest()
    {
        final LookAtTransform transform = new LookAtTransform();
        assertEquals(new MutableVector3f(0, 0, -1), transform.getInterest());
        final ImmutableVector3f translation = new ImmutableVector3f(1, 2, 3);
        assertSame(transform, transform.setInterest(translation));
        assertEquals(translation.getX(), transform.getInterest().getX(),
            0.0001f);
        assertEquals(translation.getY(), transform.getInterest().getY(),
            0.0001f);
        assertEquals(translation.getZ(), transform.getInterest().getZ(),
            0.0001f);
    }


    /**
     * Tests the interest vector with null parameter.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testInterestWithNull()
    {
        new LookAtTransform().setInterest(null);
    }


    /**
     * Tests the up vector.
     */

    @Test
    public void testUp()
    {
        final LookAtTransform transform = new LookAtTransform();
        assertEquals(new MutableVector3f(0, 1, 0), transform.getUp());
        final ImmutableVector3f translation = new ImmutableVector3f(1, 2, 3);
        assertSame(transform, transform.setUp(translation));
        assertEquals(translation.getX(), transform.getUp().getX(),
            0.0001f);
        assertEquals(translation.getY(), transform.getUp().getY(),
            0.0001f);
        assertEquals(translation.getZ(), transform.getUp().getZ(),
            0.0001f);
    }


    /**
     * Tests the up vector with null parameter.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testUpWithNull()
    {
        new LookAtTransform().setUp(null);
    }
}