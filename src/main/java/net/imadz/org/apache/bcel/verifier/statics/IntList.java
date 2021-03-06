/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License. 
 *
 */ 
package net.imadz.org.apache.bcel.verifier.statics;


import java.util.ArrayList;
import java.util.List;

/**
 * A small utility class representing a set of basic int values.
 *
 * @version $Id: IntList.java 1149459 2011-07-22 04:34:27Z dbrosius $
 * @author Enver Haase
 */
public class IntList{
	/** The int are stored as Integer objects here. */
	private List<Integer> theList;
	/** This constructor creates an empty list. */
	IntList(){
		theList = new ArrayList<Integer>();
	}
	/** Adds an element to the list. */
	void add(int i){
		theList.add(Integer.valueOf(i));
	}
	/** Checks if the specified int is already in the list. */
	boolean contains(int i){
		Integer[] ints = new Integer[theList.size()];
		theList.toArray(ints);
		for (int j=0; j<ints.length; j++){
			if (i == ints[j].intValue()) {
                return true;
            }
		}
		return false;
	}
}
