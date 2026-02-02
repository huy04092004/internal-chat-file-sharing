//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
//package it.davidenastri.clouddrive;
//
//import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
//import org.apache.mina.core.service.IoAcceptor;
//import org.apache.mina.core.service.IoAcceptorConfig;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.logging.LogLevel;
//import org.apache.mina.filter.logging.LoggingFilter;
//import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
//import org.apache.mina.util.DefaultByteBufferAllocator;
//
//import java.io.IOException;
//
//public class MinaFtpServer {
//
//    public static void main(String[] args) throws IOException {
//        IoAcceptor acceptor = new NioSocketAcceptor();
//        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
//
//        // Log các hoạt động trên server
//        chain.addLast("logger", new LoggingFilter(LogLevel.INFO));
//
//        // Tạo và cấu hình FTP handler
//        acceptor.setHandler(new FtpServerHandler());
//
//        // Đặt cấu hình của server
//        IoAcceptorConfig config = acceptor.getDefaultConfig();
//        config.setAllocator(DefaultByteBufferAllocator.DEFAULT);
//
//        // Lắng nghe kết nối tại port 2121
//        acceptor.bind(new java.net.InetSocketAddress("localhost", 2121));
//
//        System.out.println("FTP Server đang chạy trên cổng 2121...");
//    }
//}
//
//class FtpServerHandler extends org.apache.mina.core.service.IoHandlerAdapter {
//    @Override
//    public void sessionOpened(IoSession session) throws Exception {
//        // Khi có kết nối mới
//        session.write("220 Welcome to Apache Mina FTP Server!");
//    }
//
//    @Override
//    public void messageReceived(IoSession session, Object message) throws Exception {
//        String command = message.toString();
//        if (command.startsWith("USER")) {
//            session.write("331 Username okay, need password.");
//        } else if (command.startsWith("PASS")) {
//            session.write("230 User logged in.");
//        } else if (command.startsWith("QUIT")) {
//            session.write("221 Goodbye.");
//            session.closeNow();
//        } else {
//            session.write("500 Command not recognized.");
//        }
//    }
//
//    @Override
//    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        session.closeNow();
//    }
//}
