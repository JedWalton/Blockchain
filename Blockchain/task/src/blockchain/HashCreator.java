package blockchain;

import java.util.List;
import java.util.stream.Collectors;

public class HashCreator {

    public static String createHash(
            String hashOfPreviousBlock,
            int id,
            long timestamp,
            int magicNumber,
            List<Message> messages,
            String minerId
    ) {
        String strMessages = messages.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
        String data = hashOfPreviousBlock + id + timestamp + strMessages + minerId + magicNumber;
        return StringUtil.applySha256(data);
    }
}
