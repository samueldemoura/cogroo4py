# -*- coding: utf-8 -*-
import unittest

from cogroo4py import Cogroo, Document


class LemmaTest(unittest.TestCase):

    def setUp(self):
        self.cogroo = Cogroo.instance()

    def test_singleton(self):
        excpt_thrown = False
        try:
            Cogroo()
        except TypeError as e:
            excpt_thrown = True
            self.assertEqual(Cogroo.MSG_CALL_INSTANCE, '%s' % e)
        self.assertTrue(excpt_thrown)

    def test_lemma(self):
        lemma = self.cogroo.lemmatize('Estas laranjas estão deliciosas.')

        self.assertTrue(isinstance(lemma, str))
        self.assertEqual(
            lemma,
            'este laranja estar delicioso .'
        )

        self.assertEqual(self.cogroo.lemmatize(''), '')

    def test_morpho_analysis(self):
        doc = self.cogroo.analyze(
            'Estas laranjas estão deliciosas. Esta frase, e a outra.'
        )

        self.assertIsNotNone(doc)
        self.assertTrue(isinstance(doc, Document))
        self.assertNotEqual('%s' % doc.sentences[0].tokens, '')
        self.assertNotEqual('%s' % doc.sentences[0].chunks, '')
        self.assertNotEqual('%s' % doc.sentences, '')
        self.assertNotEqual('%s' % doc, '')

    def test_grammar_checker(self):
        doc = self.cogroo.grammar_check(
            'Elas são bonita.\nEles é feio.'
        )

        self.assertIsNotNone(doc)
        self.assertNotEqual(doc.mistakes, [])
        self.assertTrue(isinstance(doc, Document))
        self.assertNotEqual('%s' % doc.mistakes, '')

    def test_post_tag(self):
        pos_tag = self.cogroo.pos_tag(
            'Bem-aventurados os pacificadores, '
            'porque eles serão chamados filhos de Deus.'
        )

        self.assertEqual(
            pos_tag,
            u'Bem#prop -#- aventurados#v-pcp os#art pacificadores#n ,#, '
            u'porque#conj-s eles#pron-pers serão#v-fin chamados#v-pcp filhos#n '
            u'de#prp Deus#prop .#.'
        )

    def test_chunk_tag(self):
        chunk_tag_normal = self.cogroo.chunk_tag(
            'Bem-aventurados os misericordiosos, '
            'porque eles alcançarão misericórdia.',
            'normal'
        )
        self.assertTrue(isinstance(chunk_tag_normal, str))
        self.assertNotEqual(chunk_tag_normal, u'')

        chunk_tag_sync = self.cogroo.chunk_tag(
            'Bem-aventurados os misericordiosos, '
            'porque eles alcançarão misericórdia.',
            'sync'
        )
        self.assertTrue(isinstance(chunk_tag_sync, str))
        self.assertNotEqual(chunk_tag_sync, u'')


if __name__ == '__main__':
    unittest.main()
