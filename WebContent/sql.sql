USE [test]

/****** Object:  Table [dbo].[t_topic]    Script Date: 2019/11/3 20:51:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[t_topic](
	[tid] [int] IDENTITY(1,1) NOT NULL,
	[tname] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_t_topic] PRIMARY KEY CLUSTERED 
(
	[tid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


GO
/****** Object:  Table [dbo].[t_user]    Script Date: 2019/11/3 20:51:33 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[t_user](
	[uid] [int] IDENTITY(1,1) NOT NULL,
	[uname] [nvarchar](50) NULL,
	[upwd] [nvarchar](50) NULL,
 CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO



/****** Object:  Table [dbo].[t_news]    Script Date: 2019/11/3 20:50:23 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[t_news](
	[nid] [int] IDENTITY(1,1) NOT NULL,
	[ntid] [int] NULL,
	[ntname] [nvarchar](50) NULL,
	[ntitle] [nvarchar](50) NULL,
	[nauthor] [nvarchar](50) NULL,
	[ncreatedate] [datetime] NULL,
	[npicpath] [nvarchar](50) NULL,
	[ncontent] [nvarchar](50) NULL,
	[nmodifydate] [datetime] NULL,
	[nsummary] [nvarchar](50) NULL,
 CONSTRAINT [PK_t_news] PRIMARY KEY CLUSTERED 
(
	[nid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[t_news]  WITH CHECK ADD  CONSTRAINT [FK_t_news_t_topic] FOREIGN KEY([ntid])
REFERENCES [dbo].[t_topic] ([tid])
ON UPDATE SET NULL
ON DELETE SET NULL
GO

ALTER TABLE [dbo].[t_news] CHECK CONSTRAINT [FK_t_news_t_topic]
GO

GO



/****** Object:  Table [dbo].[t_comment]    Script Date: 2019/11/3 20:49:39 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[t_comment](
	[cid] [int] IDENTITY(1,1) NOT NULL,
	[cnid] [int] NOT NULL,
	[ccontent] [nvarchar](50) NOT NULL,
	[cdate] [datetime] NOT NULL,
	[cip] [nvarchar](50) NOT NULL,
	[cauthor] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_t_comment] PRIMARY KEY CLUSTERED 
(
	[cid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[t_comment]  WITH CHECK ADD  CONSTRAINT [FK_t_comment_t_news] FOREIGN KEY([cnid])
REFERENCES [dbo].[t_news] ([nid])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[t_comment] CHECK CONSTRAINT [FK_t_comment_t_news]
GO









