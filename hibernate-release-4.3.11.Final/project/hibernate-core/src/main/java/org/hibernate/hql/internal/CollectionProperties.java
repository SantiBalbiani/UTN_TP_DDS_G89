/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2008, 2013, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.hql.internal;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.hibernate.persister.collection.CollectionPropertyNames;

/**
 * Provides a map of collection function names to the corresponding property names.
 *
 * @author josh
 */
public final class CollectionProperties {
	public static final Map HQL_COLLECTION_PROPERTIES;

	private static final String COLLECTION_INDEX_LOWER = CollectionPropertyNames.COLLECTION_INDEX.toLowerCase(Locale.ROOT);

	static {
		HQL_COLLECTION_PROPERTIES = new HashMap();
		HQL_COLLECTION_PROPERTIES.put( CollectionPropertyNames.COLLECTION_ELEMENTS.toLowerCase(Locale.ROOT), CollectionPropertyNames.COLLECTION_ELEMENTS );
		HQL_COLLECTION_PROPERTIES.put( CollectionPropertyNames.COLLECTION_INDICES.toLowerCase(Locale.ROOT), CollectionPropertyNames.COLLECTION_INDICES );
		HQL_COLLECTION_PROPERTIES.put( CollectionPropertyNames.COLLECTION_SIZE.toLowerCase(Locale.ROOT), CollectionPropertyNames.COLLECTION_SIZE );
		HQL_COLLECTION_PROPERTIES.put( CollectionPropertyNames.COLLECTION_MAX_INDEX.toLowerCase(Locale.ROOT), CollectionPropertyNames.COLLECTION_MAX_INDEX );
		HQL_COLLECTION_PROPERTIES.put( CollectionPropertyNames.COLLECTION_MIN_INDEX.toLowerCase(Locale.ROOT), CollectionPropertyNames.COLLECTION_MIN_INDEX );
		HQL_COLLECTION_PROPERTIES.put( CollectionPropertyNames.COLLECTION_MAX_ELEMENT.toLowerCase(Locale.ROOT), CollectionPropertyNames.COLLECTION_MAX_ELEMENT );
		HQL_COLLECTION_PROPERTIES.put( CollectionPropertyNames.COLLECTION_MIN_ELEMENT.toLowerCase(Locale.ROOT), CollectionPropertyNames.COLLECTION_MIN_ELEMENT );
		HQL_COLLECTION_PROPERTIES.put( COLLECTION_INDEX_LOWER, CollectionPropertyNames.COLLECTION_INDEX );
	}

	private CollectionProperties() {
	}

	@SuppressWarnings("SimplifiableIfStatement")
	public static boolean isCollectionProperty(String name) {
		final String key = name.toLowerCase(Locale.ROOT);
		// CollectionPropertyMapping processes everything except 'index'.
		if ( COLLECTION_INDEX_LOWER.equals( key ) ) {
			return false;
		}
		else {
			return HQL_COLLECTION_PROPERTIES.containsKey( key );
		}
	}

	public static String getNormalizedPropertyName(String name) {
		return (String) HQL_COLLECTION_PROPERTIES.get( name );
	}

	public static boolean isAnyCollectionProperty(String name) {
		final String key = name.toLowerCase(Locale.ROOT);
		return HQL_COLLECTION_PROPERTIES.containsKey( key );
	}
}
