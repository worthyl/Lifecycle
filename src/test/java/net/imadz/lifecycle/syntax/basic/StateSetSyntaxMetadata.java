/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright (c) 2013-2020 Madz. All rights reserved.
 * 
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License"). You
 * may not use this file except in compliance with the License. You can
 * obtain a copy of the License at
 * https://raw.github.com/zhongdj/Lifecycle/master/License.txt
 * . See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 * 
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 * 
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license." If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above. However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package net.imadz.lifecycle.syntax.basic;

import net.imadz.lifecycle.annotations.Function;
import net.imadz.lifecycle.annotations.StateMachine;
import net.imadz.lifecycle.annotations.StateSet;
import net.imadz.lifecycle.annotations.TransitionSet;
import net.imadz.lifecycle.annotations.state.End;
import net.imadz.lifecycle.annotations.state.Initial;
import net.imadz.lifecycle.syntax.BaseMetaDataTest;
import net.imadz.lifecycle.syntax.basic.StateSetSyntaxMetadata.Positive.Transitions.T;

public class StateSetSyntaxMetadata extends BaseMetaDataTest {

    @StateMachine
    protected static interface Positive {

        @StateSet
        static interface States {

            @Initial
            @Function(transition = T.class, value = B.class)
            static interface A {};
            @End
            static interface B {};
        }
        @TransitionSet
        static interface Transitions {

            static interface T {};
        }
    }
    @StateMachine
    protected static interface Negative_No_InnerClasses {}
    @StateMachine
    protected static interface Negative_No_StateSet_and_TransitionSet {

        static interface States {

            @Initial
            @Function(transition = T.class, value = B.class)
            static interface A {};
            @End
            static interface B {};
        }
        static interface Transitions {

            static interface T {};
        }
    }
    @StateMachine
    protected static interface Negative_Multi_StateSet_Multi_TransitionSet {

        @StateSet
        static interface StatesA {}
        @StateSet
        static interface StatesB {}
        @TransitionSet
        static interface TransitionsA {}
        @TransitionSet
        static interface TransitionsB {}
    }
    @StateMachine
    protected static interface Negative_No_State_No_Transition {

        @StateSet
        static interface States {}
        @TransitionSet
        static interface Transitions {}
    }
    @StateMachine
    protected static interface Negative_StateSet_Without_InitalState_And_EndState {

        @StateSet
        static interface States {

            static interface Start {}
            static interface End {}
        }
        @TransitionSet
        static interface Transitions {

            static interface Queue {}
        }
    }
    @StateMachine
    protected static interface Negative_StateSet_With_Multi_InitalState {

        @StateSet
        static interface States {

            @Initial
            static interface Start {}
            @Initial
            static interface Queued {}
            @End
            static interface Ended {}
        }
        @TransitionSet
        static interface Transitions {

            static interface Queue {}
        }
    }
}