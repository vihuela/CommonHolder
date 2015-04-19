# CommonHolder
recycleView现在都是面向Holder，那ListView也要跟上^_^

- 仅适合ListView使用 



	    mListView.setAdapter(new CommonAdapter<New>(mContext, mNews, R.layout.item_lv) {
	            @Override
	            public void getHolder(ViewHolder holder, New item) {
	                holder.setText(R.id.tv_title, item.title);
	                holder.setText(R.id.tv_detail, item.datail);
	                holder.setText(R.id.tv_follow, item.follow);
	                holder.setImageUrl(R.id.iv_photo, item.avator);
	            }
	        });
