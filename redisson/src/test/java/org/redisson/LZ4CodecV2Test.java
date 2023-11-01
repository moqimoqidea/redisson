package org.redisson;

import org.junit.jupiter.api.Test;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.codec.LZ4Codec;
import org.redisson.codec.LZ4CodecV2;
import org.redisson.config.Config;

import static org.assertj.core.api.Assertions.assertThat;

public class LZ4CodecV2Test extends BaseTest {

    @Test
    public void test1() {
        Config config = new Config();
        config.setCodec(new LZ4Codec());
        config.useSingleServer()
                .setAddress(RedisRunner.getDefaultRedisServerBindAddressAndPort());
        RedissonClient r = Redisson.create(config);
        RBucket<String> s = r.getBucket("test1");
        s.set("12324");

        Config config2 = new Config();
        config2.setCodec(new LZ4CodecV2());
        config2.useSingleServer()
                .setAddress(RedisRunner.getDefaultRedisServerBindAddressAndPort());
        RedissonClient r2 = Redisson.create(config2);
        RBucket<String> s2 = r2.getBucket("test1");
        assertThat(s2.get()).isEqualTo("12324");
    }

}
