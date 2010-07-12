/*
 * Copyright (C) 2010 Klaus Reimer <k@ailis.de>
 * See LICENSE.txt for licensing information.
 */

package de.ailis.collada.model;


/**
 * The common source technique.
 *
 * @author Klaus Reimer (k@ailis.de)
 */

public final class CommonSourceTechnique extends Element
{
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    /** The list of material instances. */
    private Accessor accessor;


    /**
     * Returns the accessor.
     *
     * @return The accessor. Never null.
     */

    public Accessor getAccessor()
    {
        return this.accessor;
    }
}
