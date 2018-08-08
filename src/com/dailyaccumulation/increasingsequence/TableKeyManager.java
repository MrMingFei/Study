package com.dailyaccumulation.increasingsequence;

import java.util.Date;
/*
@Service
@Transactional
public class TableKeyManager extends IncrementNumber {

    public TableKeyManager() {
        super(100, 99999999);
    }

    @Override
    public int initStartNum() throws Exception {
        TableKey tableKey = tableKeyDao.getById(name);
        date = DateConvertUtils.getDayEnd(DateConvertUtils.parse(tableKey.getDate(), "yyMMdd"));
        dateEndMillis = date.getTime();
        prefix = tableKey.getDate();
        return (int) tableKey.getMaxNum();
    }

    @Override
    public void updateStartNum(int intervalMax) throws Exception {
        TableKey tableKey = tableKeyDao.getById(name);
        tableKey.setDate(DateConvertUtils.format(new Date(dateEndMillis), "yyMMdd"));
        tableKey.setMaxNum(intervalMax);
        tableKeyDao.update(tableKey);
    }

    public String getNum() {
        try {
            long now = System.currentTimeMillis();
            int no = 0;
            if (now > dateEndMillis) {
                date = DateConvertUtils.getDayEnd(new Date(now));
                dateEndMillis = date.getTime();
                prefix = DateConvertUtils.format(date, "yyMMdd");
                resetSerialNum();
                no = this.serialNum;
            } else {
                no = cal();
            }
            return prefix + ApplicationUtil.getFixedSizeNum(no, 8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("生成序列号错误");
    }

    public void setName(String name) {
        this.name = name;
    }

    private String prefix = null;

    private long dateEndMillis = 0l;

    private Date date = null;

    private String name;

    @Autowired
    private TableKeyDao tableKeyDao;
}
CREATE TABLE `table_key` (
  `key_name` varchar(100) NOT NULL COMMENT '需要维护的key名称',
  `cur_no` mediumtext COMMENT '当前数据编号',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据编号更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '记录创建时间',
  PRIMARY KEY (`key_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8  */
