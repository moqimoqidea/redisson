/**
 * Copyright (c) 2013-2024 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.api;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Nikita Koksharov
 *
 */
@Deprecated
public enum RateIntervalUnit {

    
    MILLISECONDS {
        @Override
        public long toMillis(long value) {
            return value;
        }
    },

    SECONDS {
        @Override
        public long toMillis(long value) {
            return TimeUnit.SECONDS.toMillis(value);
        }
    },
    
    MINUTES {
        @Override
        public long toMillis(long value) {
            return TimeUnit.MINUTES.toMillis(value);
        }
    },
    
    HOURS {
        @Override
        public long toMillis(long value) {
            return TimeUnit.HOURS.toMillis(value);
        }
    },
    
    DAYS {
        @Override
        public long toMillis(long value) {
            return TimeUnit.DAYS.toMillis(value);
        }
    };
    
    public abstract long toMillis(long value);
}
