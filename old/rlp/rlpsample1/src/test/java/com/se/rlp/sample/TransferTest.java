package com.se.rlp.sample;

import com.com.soapbox.basenode.consensus.accounts.Address;
import com.com.soapbox.basenode.consensus.accounts.ParseException;
import com.soapbox.basenode.consensus.enums.TransactionParseException;
import com.soapbox.basenode.consensus.enums.TransactionType;
import com.soapbox.basenode.consensus.exception.IncorrectTransactionException;
import com.soapbox.basenode.consensus.transactions.*;
import net.consensys.cava.bytes.Bytes;
import net.consensys.cava.rlp.RLP;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TransferTest {


    private static final byte[] TRANSFER_ADDRESS = "ADDRESS_LENGTH_ADDRE".getBytes(StandardCharsets.UTF_8);

    private static final byte[] TRANSFER_DATA = "TRANSFER_DATA".getBytes(StandardCharsets.UTF_8);
    private static final BigInteger TRANSFER_VALUE = BigInteger.valueOf(1);
    private static final BigInteger TRANSFER_COMMISSION_VALUE = BigInteger.valueOf(2);
    private static final long TRANSFER_CREATED = 1553593688172l;
    private static final long TRANSFER_TIMEOUT = 1000;

    private static final byte[] TRANSFER_V = "v".getBytes(StandardCharsets.UTF_8);
    private static final byte[] TRANSFER_R = "r".getBytes(StandardCharsets.UTF_8);
    private static final byte[] TRANSFER_S = "s".getBytes(StandardCharsets.UTF_8);

    private static final TransactionType transactionType = TransactionType.Transfer;
    RLPElement rlp_v = new RLPElement(TRANSFER_V);
    RLPElement rlp_r = new RLPElement(TRANSFER_R);
    RLPElement rlp_s = new RLPElement(TRANSFER_S);
    VRS vrs = new VRS(rlp_v, rlp_r, rlp_s);
    CryptoCurrencyAmount value = new CryptoCurrencyAmount(TRANSFER_VALUE);
    CryptoCurrencyAmount commission = new CryptoCurrencyAmount(TRANSFER_COMMISSION_VALUE);
    RLPElement rlp_data = new RLPElement(TRANSFER_DATA);
    private Transaction transfer;

    @Before
    public void init() throws ParseException, IncorrectTransactionException {

        Address address = new Address(TRANSFER_ADDRESS);
        // transfer = new Transfer(address, value, commission, TRANSFER_CREATED, TRANSFER_TIMEOUT, rlp_data, vrs);

        Transaction.TransactionBuilder builder = new Transaction.TransactionBuilder();
        builder.withBaseInfo(transactionType, address, value, commission, TRANSFER_CREATED, TRANSFER_TIMEOUT, rlp_data);
        builder.signTransaction(rlp_v, rlp_r, rlp_s);
        transfer = builder.build();
    }

    @Test
    public void should_parse_unparse_correct() throws TransactionParseException {

        Bytes bytes = transfer.getBytes();
        TransactionRLP transactionRLP = new TransactionRLP(TransactionType.Transfer, bytes);
        Transaction transferParsed = Transaction.parse(transactionRLP);

        assertEquals(transfer.transactionType, transferParsed.transactionType);
        assertArrayEquals(transfer.getTo().toBytes(), transferParsed.getTo().toBytes());
        assertEquals(transfer.getValue(), transferParsed.getValue());
        assertEquals(transfer.getCommission(), transferParsed.getCommission());

        assertEquals(transfer.getCreated(), transferParsed.getCreated());
        assertEquals(transfer.getTimeOut(), transferParsed.getTimeOut());
        assertEquals(transfer.getVrs(), transferParsed.getVrs());
    }
    //---------------------------------- transationbuilder

    @Test(expected = NullPointerException.class)
    public void transBuilder_incorrect_to() throws ParseException, IncorrectTransactionException {
        Address address = new Address(TRANSFER_ADDRESS);

        Transaction.TransactionBuilder builder = new Transaction.TransactionBuilder();

        builder.withBaseInfo(null, address, value, commission, TRANSFER_CREATED, TRANSFER_TIMEOUT, rlp_data);
        builder.signTransaction(rlp_v, rlp_r, rlp_s);
        transfer = builder.build();
    }

    @Test(expected = NullPointerException.class)
    public void transBuilder_incorrect_arress() throws ParseException, IncorrectTransactionException {
        Address address = new Address(TRANSFER_ADDRESS);

        Transaction.TransactionBuilder builder = new Transaction.TransactionBuilder();

        builder.withBaseInfo(TransactionType.Transfer, null, value, commission,
                TRANSFER_CREATED, TRANSFER_TIMEOUT, rlp_data);

    }

    //----------------------------------  tranction from bytes

    @Test
    public void fromBytes_correct_rlp() throws ParseException, TransactionParseException {
        Address address = new Address(TRANSFER_ADDRESS);
        Bytes rlpAddres = RLP.encode(writer -> writer.writeByteArray(address.toBytes()));
        Bytes rlpValue = RLP.encode(writer -> writer.writeBigInteger(TRANSFER_VALUE));
        Bytes rlpCommission = RLP.encode(writer -> writer.writeBigInteger(TRANSFER_COMMISSION_VALUE));

        Bytes rlpCreated = RLP.encode(writer -> writer.writeLong(TRANSFER_CREATED));
        Bytes rlpTimeout = RLP.encode(writer -> writer.writeLong(TRANSFER_TIMEOUT));
        Bytes rlpData = RLP.encode(rlpWriter -> rlpWriter.writeValue(rlp_data.getBytes()));

        Bytes rlpVRS = RLP.encode(rlpWriter -> rlpWriter.writeValue(vrs.getBytes()));
        Bytes rlpSource = Bytes.wrap(rlpAddres, rlpValue, rlpCommission, rlpCreated, rlpTimeout,rlpData, rlpVRS);
         Transaction resultsTransfer = Transfer.fromBytes(rlpSource);

        Assert.assertNotNull(resultsTransfer);

    }


    @Test
    public void fromBytes_incorrect_input_rlp() {

    }

    public void fromBytes_incorrect_input_transactrin_rlp() {

    }


    @Test
    public void fromBytes_zero_len() {

    }

    public void fromBytes_one_bytes_len() {

    }

    public void fromBytes_incoorect_transaction_type() {

    }

    public void longToByteArray(long value, byte[] array, int startFrom) {
        for (int i = 7; i >= 0; i--) {
            array[startFrom + 7 - i] = (byte) (value >> i * 8);
        }
    }

    public byte[] longToByteArray(long value) {
        byte[] array = new byte[8];

        longToByteArray(value, array, 0);
        return array;
    }

    @Test
    public void should_un_parse_transaction_hash() throws TransactionParseException {


    }

}
