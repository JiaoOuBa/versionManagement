package com.ulearing.versionmanagement.svn;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import org.tmatesoft.svn.core.*;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.fs.FSRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class ModerOption {

    //svn地址
    private static String url = "http://119.57.68.35:8001/svn2/umooc/tags/umooc-service";
    private static SVNRepository repository = null;


    public void filterCommitHistory() throws Exception {
        DAVRepositoryFactory.setup();
        SVNRepositoryFactoryImpl.setup();
        FSRepositoryFactory.setup();
        try {
            repository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(url));
        }
        catch (SVNException e) {
            e.printStackTrace();
        }
        // 身份验证
        ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager("tanh","ulearning");
        repository.setAuthenticationManager(authManager);


        // 过滤条件
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        final Date begin = format.parse("2020-07-01");
        final Date end = format.parse("2020-09-07");
        final String author = "";  //过滤提交人
        long startRevision = 0;
        long endRevision = -1;//表示最后一个版本
        final List<String> history = new ArrayList<String>();
        //String[] 为过滤的文件路径前缀，为空表示不进行过滤
        repository.log(new String[]{""},
                startRevision,
                endRevision,
                true,
                true,
                new ISVNLogEntryHandler() {
                    @Override
                    public void handleLogEntry(SVNLogEntry svnlogentry)
                            throws SVNException {
                        //依据提交时间进行过滤
                        if (svnlogentry.getDate().after(begin)
                                && svnlogentry.getDate().before(end)) {
                            // 依据提交人过滤
                            if (!"".equals(author)) {
                                if (author.equals(svnlogentry.getAuthor())) {
                                    fillResult(svnlogentry);
                                }
                            } else {
                                fillResult(svnlogentry);
                            }
                        }
                    }

                    public void fillResult(SVNLogEntry svnlogentry) {
                        //getChangedPaths为提交的历史记录MAP key为文件名，value为文件详情
                        history.addAll(svnlogentry.getChangedPaths().keySet());
                    }
                });
        for (String path : history) {
//            System.out.println(path);
        }

        listEntries(repository, "");
    }


    /*
    * 此函数递归的获取版本库中某一目录下的所有条目。
    */
    public static void listEntries(SVNRepository repository, String path)
            throws SVNException {
        //获取版本库的path目录下的所有条目。参数－1表示是最新版本。
        Collection entries = repository.getDir(path, -1, null,(Collection) null);

//        Iterator iterator = entries.iterator();
        List<SVNDirEntry> list = new  ArrayList<SVNDirEntry>(entries);
        List<SVNDirEntry> list2 = list.stream().sorted(Comparator.comparing(SVNDirEntry::getDate).reversed()).limit(15).collect(Collectors.toList());

        list.sort((a1, a2) -> (int)(a1.getDate().getTime() - a2.getDate().getTime()));
        for (SVNDirEntry s: list2) {
            System.out.println(s.getName());
        }
    }

    public static void main(String[] args) throws Exception {
        ModerOption test = new ModerOption();
        test.filterCommitHistory();
    }
}