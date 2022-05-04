package rocketmq.basic;

import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author tong
 */
public class _1_SimpleExample {
    //同步发送消息
    //可靠同步传输应用场景广泛，如重要通知消息、短信通知、短信营销系统等。
    public static class SyncProducer {
        public static void main(String[] args) throws Exception {
            //Instantiate with a producer group name.
            DefaultMQProducer producer = new
                    DefaultMQProducer("please_rename_unique_group_name");
            // Specify name server addresses.
            producer.setNamesrvAddr("localhost:9876");
            //Launch the instance.
            producer.start();
            for (int i = 0; i < 100; i++) {
                //Create a message instance, specifying topic, tag and message body.
                Message msg = new Message("TopicTest" /* Topic */,
                        "TagA" /* Tag */,
                        ("Hello RocketMQ " +
                                i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
                );
                //Call send message to deliver message to one of brokers.
                SendResult sendResult = producer.send(msg);
                System.out.printf("%s%n", sendResult);
            }
            //Shut down once the producer instance is not longer in use.
            producer.shutdown();
        }
    }

    // 异步发送消息
    //异步传输一般用于响应时间敏感的业务场景。
    public static class AsyncProducer {
        public static void main(String[] args) throws Exception {
            //Instantiate with a producer group name.
            DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
            // Specify name server addresses.
            producer.setNamesrvAddr("localhost:9876");
            //Launch the instance.
            producer.start();
            producer.setRetryTimesWhenSendAsyncFailed(0);

            int messageCount = 100;
            final CountDownLatch countDownLatch = new CountDownLatch(messageCount);
            for (int i = 0; i < messageCount; i++) {
                try {
                    final int index = i;
                    Message msg = new Message("TopicTest",
                            "TagA",
                            "OrderID188",
                            "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
                    producer.send(msg, new SendCallback() {
                        @Override
                        public void onSuccess(SendResult sendResult) {
                            countDownLatch.countDown();
                            System.out.printf("%-10d OK %s %n", index, sendResult.getMsgId());
                        }

                        @Override
                        public void onException(Throwable e) {
                            countDownLatch.countDown();
                            System.out.printf("%-10d Exception %s %n", index, e);
                            e.printStackTrace();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            countDownLatch.await(5, TimeUnit.SECONDS);
            producer.shutdown();
        }
    }

    //单向发送消息，单向传输用于需要中等可靠性的情况，例如日志收集。
    public static class OnewayProducer {
        public static void main(String[] args) throws Exception{
            //Instantiate with a producer group name.
            DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
            // Specify name server addresses.
            producer.setNamesrvAddr("localhost:9876");
            //Launch the instance.
            producer.start();
            for (int i = 0; i < 100; i++) {
                //Create a message instance, specifying topic, tag and message body.
                Message msg = new Message("TopicTest" /* Topic */,
                        "TagA" /* Tag */,
                        ("Hello RocketMQ " +
                                i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
                );
                //Call send message to deliver message to one of brokers.
                producer.sendOneway(msg);
            }
            //Wait for sending to complete
            Thread.sleep(5000);
            producer.shutdown();
        }
    }

    public static class PushConsumer {

        public static void main(String[] args) throws InterruptedException, MQClientException {

            // Instantiate with specified consumer group name.
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please_rename_unique_group_name");

            // Specify name server addresses.
            consumer.setNamesrvAddr("localhost:9876");

            // Subscribe one more more topics to consume.
            consumer.subscribe("TopicTest", "*");
            // Register callback to execute on arrival of messages fetched from brokers.
            consumer.registerMessageListener(new MessageListenerConcurrently() {

                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                                ConsumeConcurrentlyContext context) {
                    System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });

            //Launch the consumer instance.
            consumer.start();

            System.out.printf("Push Consumer Started.%n");
        }
    }

    public static class PullConsumer {

        public static void main(String[] args) throws InterruptedException, MQClientException {
            // Instantiate with specified consumer group name.
            DefaultLitePullConsumer consumer = new DefaultLitePullConsumer("please_rename_unique_group_name");
            // Specify name server addresses.
            consumer.setNamesrvAddr("localhost:9876");
            consumer.start();

            Collection<MessageQueue> mqs = consumer.fetchMessageQueues("TopicTest");
            System.out.println("queues: ");
            mqs.forEach(System.out::println);

            System.out.println("messages: ");
            consumer.assign(mqs);

            List<MessageExt> poll = consumer.poll();
            poll.forEach(System.out::println);
        }
    }
}
