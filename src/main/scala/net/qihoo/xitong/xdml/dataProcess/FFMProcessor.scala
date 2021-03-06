package net.qihoo.xitong.xdml.dataProcess
import org.apache.spark.rdd.RDD

object FFMProcessor {
	//process data format in libffm
	def processData(data:RDD[String],separator:String = " "):RDD[(Double,Array[Int],Array[Long],Array[Float])]={
		data.map{ line =>
			val splits = line.split(separator)
			val featureList = splits.slice(1, splits.length)
			(if(splits(0).toDouble > 0) 1.0D else 0.0D, featureList.map(x=>x.split(":")(0).toInt),featureList.map(x=>x.split(":")(1).toLong), featureList.map(x=>x.split(":")(2).toFloat))
		}
	}
}
